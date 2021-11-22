const currentTimestamp = new Date();

var entry = new Vue({
    el: "#createEntry",
    data () {
        return{
          checkInDate: "",
          checkOutDate: "",
          category: ""
        }
    },
    methods: {
      sendEntryData: function () {
          axios.post('http://localhost:8080/entries',{
              checkIn: this.checkInDate,
              checkOut: this.checkOutDate,
              category: this.category.choice
          })
          .then(res => {
              console.log(res)
              //this.indexEntryData();
          })
          .catch(err => {
              console.error(err); 
          })
      },
      indexEntryData: function () {
          axios.get('http://localhost:8080/entries',{
              
          })
          .then(res => {
              console.log(res)
          })
          .catch(err => {
              console.error(err); 
          })
      },
      goToAdmin: function() {
        window.location.href = "http://localhost:8080/admin.html";
      }
    }
})

var updateEntry = new Vue({
    el: "#update",
    data () {
        return{
          id_update: "",
          checkIn_update: "",
          checkOut_update: "",
          category_update: ""
        }
    },
    methods: {
        sendUpdateData: function () {
            axios.put('http://localhost:8080/entries',{
                id: this.id_update,
                checkIn: this.checkIn_update,
                checkOut: this.checkOut_update,
                category: this.category_update.choice,
                user: ""
            })
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.error(err); 
            })
        }
    }
})

var deleteEntry = new Vue({
    el: "#delete",
    data () {
        return{
            id_delete: ""
        }
    },
    methods: {
        sendDeleteData: function () {
            axios.delete('http://localhost:8080/entries/' + this.id_delete,{
                
             })
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.error(err); 
            }) 
         }
    }
})