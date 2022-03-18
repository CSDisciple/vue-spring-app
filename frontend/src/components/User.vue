<template>
 <div id="app">

  <section v-if="errored">
    <p>We're sorry, we're not able to retrieve this information at the moment, please try back later</p>
  </section>
  <table class="table">
     <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Last</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="person in info" :key="person">
      <td> {{person.id}} </td>
      <td> {{person.name}} </td>
    </tr>
  </tbody>
  </table>
</div>
</template>

<script>
export default {
  name: 'User',
  data () {
    return {
      info: null,
      loading: true,
      errored: false
    }
  },
  created () {
    fetch('http://localhost:8080/members', { mode: 'cors' })
      .then(response => {
        if (response.status !== 200) {
          console.log('Status response', response.status)
          return
        }

        response.json()
          .then(data => {
            this.info = data
          })
      })
      .catch(error => {
        console.log(error)
        this.errored = true
      })
      .finally(function () { this.loading = false })
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body{
  background-color:  ivory;
}
section{
  display: flex;
  flex-flow: column;
  align-content: center;
  justify-content: space-evenly;
  height: 200px;
  width: 50%;
  margin: 0 auto;
  background-color: cadetblue;

}

</style>
