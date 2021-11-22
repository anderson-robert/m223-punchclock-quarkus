package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@ApplicationScoped
public class LogService {

    @Inject
    private EntityManager entityManager;

    public LogService() {
    }

    @Transactional
    public Log createLog(Log log) {
        entityManager.persist(log);
        return log;
    }

    public Log getSingleLog(Long id){
        return entityManager.find(Log.class, id);
    }

    @Transactional
    public void deleteLog(Long id){
        Log logToDelete = getSingleLog(id);
        entityManager.remove(logToDelete);
    }

    @Transactional
    public void updateLog(Log log){
        entityManager.merge(log);
    }

    @SuppressWarnings("unchecked")
    public List<Log> findAll() {
        var query = entityManager.createQuery("FROM Log");
        return query.getResultList();
    }

    public void createLogFile(String logType, Long userID) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File newFile = new File("/src/main/resources/Logs/log_" + logType + "_" + timestamp);
        if (newFile.createNewFile()) {
            System.out.println("File created: " + newFile.getName());
        } else {
            System.out.println("File already exists");
        }
        FileWriter fileWriter = new FileWriter(newFile);
        fileWriter.write("Log Type: " + logType + ", User ID: " + userID + ", Timestamp: " + timestamp);
        fileWriter.close();
    }

}
