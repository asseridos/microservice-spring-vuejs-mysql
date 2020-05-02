import Vue from 'vue'
import Router from 'vue-router'
import car from '@/components/car'
import carWash from '@/components/car-wash'
import carRental from '@/components/car-rental'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  linkActiveClass: 'active',
  routes: [
    {
      path: '/',
      redirect: '/car',
    },
    {
      path: '/car',
      name: 'car_form',
      component: car
    },
    {
      path: '/car-wash',
      name: 'car_wash_form',
      component: carWash
    },
    {
      path: '/car-rental',
      name: 'car_rental_form',
      component: carRental
    }

  ]
})

export default router