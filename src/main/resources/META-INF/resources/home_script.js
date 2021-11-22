const currentTimestamp = new Date();

var entry = new Vue({
    el: "#createEntry",
    data () {
        return{
          checkInDate: "",
          checkOutDate: ""
        }
    },
    methods: {
      sendEntryData: function () {
          axios.post('http://localhost:8080/entries',{
              checkIn: this.checkInDate,
              checkOut: this.checkOutDate,
              category: Object.category,
              user: Object.user
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
      }
    }
})