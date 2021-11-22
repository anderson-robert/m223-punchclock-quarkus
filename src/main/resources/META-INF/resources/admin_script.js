var update = new Vue({
    el: "#update",
    data () {
        return{
            id_update: "",
            benutzername_update: "",
            passwort_update: ""
        }
    },
    methods: {
        sendUserUpdateData: function () {
            axios.put('http://localhost:8080/register',{
                id: this.id_update,
                username: this.benutzername_update,
                password: this.passwort_update
            })
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.error(err); 
            })
        }
    },
})

var deleteUser = new Vue({
    el: "#delete",
    data () {
        return{
            id_delete: ""
        }
    },
    methods: {
        sendUserDeleteData: function () {
           axios.delete('http://localhost:8080/register/' + this.id_delete,{
               
            })
           .then(res => {
               console.log(res)
           })
           .catch(err => {
               console.error(err); 
           }) 
        }
    },
})