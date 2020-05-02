<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <router-link class="navbar-brand" to="/car">
      Navbar
    </router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link class="nav-link" to="/car">
            Voiture
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/car-wash">
            Lavage
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/car-rental">
            Location
          </router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  data () {
    return {}
  }
}
</script>

