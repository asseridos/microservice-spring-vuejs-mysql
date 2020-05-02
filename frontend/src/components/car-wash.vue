<template>
  <div class="col-12 col-md-6 col-lg-4 my-5 mx-auto">
    <div class="card">
      <div class="card-body">
        <form @submit.prevent="onSubmit">
          <div class="form-group">
            <label>Type de lavage</label>
            <select class="form-control" v-model="car_wash.washType">
              <option value="deluxe">Deluxe</option>
              <option value="standard">Standard</option>
              <option value="economic">Economic</option>
            </select>
          </div>
          <div class="form-group">
            <label>Prix</label>
            <input type="number" class="form-control" v-model="car_wash.price">
          </div>
          <div class="col-sm-6 form-group">
            <label>Statut</label>
            <select class="form-control" v-model="car_wash.status">
              <option value="ongoing">Ongoing</option>
              <option value="done">Done</option>
              <option value="cancelled">Cancelled</option>
            </select>
          </div>
          <div class="form-group">
            <label>Voiture</label>
            <select class="form-control" v-model="car_wash.carId">
              <option v-for="(car) in cars" :value="car.id">{{ car.brand+ ' ' + car.model }}</option>
            </select>
          </div>
          <div class="form-group mt-4">
            <button type="submit" class="btn btn-primary" :disabled="isloading">
              <span v-if="isloading" class="spinner-grow spinner-grow-sm"
                role="status" aria-hidden="true"></span>
              Valider
            </button>
          </div>
        </form>
      </div>
    </div>
    <h2 class="mt-5">Liste des lavages</h2>
    <table>
      <thead>
        <th>Wash Type</th>
        <th>Price</th>
        <th>Status</th>
        <th>CarId</th>
      </thead>
      <tr
        v-for="(wash, index) in washes"
        :key="index">
        <td>{{ wash.washType }}</td>
        <td>{{ wash.price }}</td>
        <td>{{ wash.status }}</td>
        <td>{{ wash.carId }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from '../config/wash_http';
export default {
  name: 'car_wash_form',

  data () {
    return {
      isloading: false,
      washes: [],
      cars: [],
      car_wash: {
        washType: '',
        price: '',
        status: '',
        car_id: ''
      }
    }
  },

  methods: {
    onSubmit () {
      axios.post(`/washes`, this.car_wash)
        .then((res) => {
          this.washes.push(res.data)
          this.isloading = false
        }).catch((err) => {
          // alert(`${JSON.parse(JSON.stringify(err.response.data))}`)
          this.isloading = false
        })
    }
  },
  mounted () {
    axios.get(`/washes`)
    .then((res) => {
      this.washes = res.data._embedded.washes
      this.isloading = false
    }).catch((err) => {
      console.log(err);
      // alert(`${JSON.parse(JSON.stringify(err.response.data))}`)
      this.isloading = false
    })

    axios.get(`process.env.RENT_API/cars`)
    .then((res) => {
      this.cars = res.data._embedded.cars
      this.isloading = false
    }).catch((err) => {
      console.log(err);
      // alert(`${JSON.parse(JSON.stringify(err.response.data))}`)
      this.isloading = false
    })
  }
}
</script>
