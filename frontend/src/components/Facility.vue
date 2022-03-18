<template>
  <div>
    <div v-if="error">
      <p>Sorry but there was an error and we could not load your data!</p>
    </div>
    <div v-else>
      <table>
        <thead>
          <th>Facility ID</th>
          <th>Member Name</th>
          <th>Member Cost</th>
          <th>Guest Cost</th>
          <th>Initial Outlay</th>
          <th>Monthly Maintenance</th>
        </thead>
        <tbody>
          <tr v-for="member in info" :key="member">
            <td>
              {{ member.id }}
            </td>
            <td>
                {{member.name}}
            </td>
             <td>
                {{member.memberCost}}
            </td>
             <td>
                {{member.guestCost}}
            </td>
             <td>
                {{member.initialOutlay}}
            </td>
             <td>
                {{member.monthlyMaintenance}}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Facility',
  data () {
    return {
      info: null,
      error: false
    }
  },
  created () {
    fetch('http://localhost:8080/facilities')
      .then((response) => {
        if (response.status !== 200) {
          console.log(
            'We got a bad response with a status code: ',
            response.status
          )
        }

        response.json().then((data) => {
          this.info = data
          this.info.array.forEach(element => {
            console.log(element.name)
          })
        })
      })
      .catch((error) => {
        console.log(error)
        this.error = true
      })
  }
}
</script>
<style scoped>
</style>
