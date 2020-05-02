<template>
  <div class="container">
    <div class="row">
      <div class="col-12 col-md-7 col-lg-6 mx-auto my-5">
        <div class="card">
          <div class="card-body">
            <form @submit.prevent="onSubmit">
              <div class="row">
                <div class="col-sm-6 form-group">
                  <label>Model</label>
                  <input type="text" class="form-control" v-model="car.model">
                </div>
                <div class="col-sm-6 form-group">
                  <label>Plaque d'imatriculation</label>
                  <input type="text" class="form-control" v-model="car.plateNumber">
                </div>
                <div class="col-sm-6 form-group">
                  <label>Marque</label>
                  <input type="text" class="form-control" v-model="car.brand">
                </div>
                <div class="col-sm-6 form-group">
                  <label>Prix</label>
                  <input type="number" class="form-control" v-model="car.price">
                </div>
                <div class="col-12 form-group">
                  <label>Description</label>
                  <textarea class="form-control" rows="3" v-model="car.description"></textarea>
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
      </div>
    </div>
    <div class="row">
      <div class="col-6 mx-auto">
        <h2 class="mt-5">Liste des voitures</h2>
        <table>
          <thead>
            <th>Brand</th>
            <th>Model</th>
            <th>PlateNumber</th>
            <th>Price</th>
            <th>Description</th>
          </thead>
          <tr
            v-for="(car, index) in cars"
            :key="index">
            <td>{{ car.brand }}</td>
            <td>{{ car.model }}</td>
            <td>{{ car.plateNumber }}</td>
            <td>{{ car.price }}</td>
            <td>{{ car.description }}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>

</template>

<script>
import axios from '../config/rental_http';
export default {
  name: 'car_form',

  data () {
    return {
      isloading: false,
      cars: [],
      car: {
        model: '',
        plate_number: '',
        brand: '',
        price: '',
        description: '',
      }
    }
  },

  methods: {
    onSubmit () {
      axios.post(`/cars`, this.car)
        .then((res) => {
          console.log(res);
          this.car = {}
          this.cars.push(res.data)
          this.isloading = false
        }).catch((err) => {
          console.log(err);
          // alert(`${JSON.parse(JSON.stringify(err.response.data))}`)
          this.isloading = false
        })
    }
  },
  mounted () {
    axios.get(`/cars`)
    .then((res) => {
      console.log(res);
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
