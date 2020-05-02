<template>
  <div class="col-12 col-md-7 col-lg-6 mx-auto my-5">
    <div class="card">
      <div class="card-body">
        <form @submit.prevent="onSubmit">
          <div class="row">
            <div class="col-sm-6 form-group">
              <label class="">Date de début</label>
              <date-picker v-model="car_rental.startDate" :clearable="true"
                input-class="form-control w-100"></date-picker>
            </div>
            <div class="col-sm-6 form-group">
              <label>Date de fin</label>
              <date-picker v-model="car_rental.endDate" :clearable="true"
                input-class="form-control w-100"></date-picker>
            </div>
            <div class="col-sm-6 form-group">
              <label>Statut</label>
              <select class="form-control" v-model="car_rental.status">
                <option value="ongoing">Ongoing</option>
                <option value="done">Done</option>
                <option value="cancelled">Cancelled</option>
              </select>
            </div>
            <div class="col-sm-6 form-group">
              <label>Voiture</label>
              <select class="form-control" v-model="car_rental.carId">
                <option v-for="(car) in cars" :value="car.id">{{ car.brand+ ' ' + car.model }}</option>
              </select>
            </div>

            <div class="col-12 mt-2">
              <button type="submit" class="btn btn-primary" :disabled="isloading">
                <span v-if="isloading" class="spinner-grow spinner-grow-sm"
                  role="status" aria-hidden="true"></span>
                Valider
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <h2 class="mt-5">Liste des locations de voiture</h2>
    <table>
      <thead>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Status</th>
        <th>CarId</th>
      </thead>
      <tr
        v-for="(rent, index) in rents"
        :key="index">
        <td>{{ rent.startDate }}</td>
        <td>{{ rent.endDate }}</td>
        <td>{{ rent.status }}</td>
        <td>{{ rent.carId }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from '../config/rental_http';
import DatePicker from 'vue2-datepicker';
import 'vue2-datepicker/index.css';

export default {
  name: 'car_rental_form',

  components: {
    DatePicker,
  },

  data () {
    return {
      isloading: false,
      rents: [],
      cars: [],
      car_rental: {
        startDate: '',
        endDate: '',
        status: '',
        carId: ''
      }
    }
  },

  methods: {
    onSubmit () {
      this.isloading = true
      axios.post(`/rents`, this.car_rental)
        .then((res) => {
          this.rents.push(res.data)
          this.isloading = false
        }).catch((err) => {
          // alert(`${JSON.parse(JSON.stringify(err.response.data))}`)
          this.isloading = false
        })
    }
  },
  mounted () {
    axios.get(`/rents`)
    .then((res) => {
      this.rents = res.data._embedded.rents
      this.isloading = false
    }).catch((err) => {
      console.log(err);
      // alert(`${JSON.parse(JSON.stringify(err.response.data))}`)
      this.isloading = false
    })

    axios.get(`/cars`)
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

<style scoped>
  .mx-datepicker {
    width: 100%;
  }
</style>
