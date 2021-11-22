const clientPath = "http://localhost:8080/";
const currentTimestamp = new Date();

var registration = new Vue({
    el: '#registration',
    data () {
        return{
            benutzername_reg: "",
            passwort_reg: ""
        }
    },
    methods: {
        sendRegistrationData: function () {
            axios.post('http://localhost:8080/register', {
                username: this.benutzername_reg,
                password: this.passwort_reg
          })
          .then(function (response) {
            console.log(response);

          })
          .catch(function (error) {
            console.log(error);
          });
        }
    },
  })

var login = new Vue({
    el: '#login',
    data () {
        return{
            benutzername_log: "",
            passwort_log: "",
            path: "src/main/resources/Logs",
            content: " ",
            timestamp: currentTimestamp
        }
    },
    methods: {
        sendLogData: function () {
            axios.post('http://localhost:8080/logs/createLogFile', {
                logType: Object.logType,
                user: Object.user
            
            })
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.error(err); 
            })
        },
        sendLoginData: function () {
            axios.post('http://localhost:8080/auth/login', {
                username: this.benutzername_log,
                password: this.passwort_log
          })
          .then(function (response) {
            console.log(response);
            sendLogData;
            window.location.href = "http://localhost:8080/home.html";
          })
          .catch(function (error) {
            console.log(error);
          });
        }
    },
  })

/*
const URL = 'http://localhost:8080';
let entries = [];
let loginInput = {};

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    });
};

const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createEntryForm');
    createEntryForm.addEventListener('submit', createEntry);
    indexEntries();
});

clickLogin = (e) => {
    e.preventDefault;
    fetch ("API Address", {
        method: "POST",
        body: JSON.stringify({
            username: this.state.usernameValue,
            password: this.state.passwordValue
        }),
    })
    .then((response) => response.json())
    .then((result) => {
        if(result.message === "SUCCESS"){
            alert("You are logged in.");
        } else {
            alert("Login failed.");
        }
    });
}
*/