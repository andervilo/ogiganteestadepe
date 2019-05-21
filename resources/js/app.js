
import Vue from "vue"
import VueRouter from "vue-router"
import Quasar from "./quasar.mat.umd.min.js"
require("./i18n.pt-br.umd.min.js")
require("./quasar.ie.polyfills.umd.min.js")

Vue.use(VueRouter)


import Cidades from './components/lista-cidades'
import Principal from './components/principal'
import CidadesAdd from './components/lista-cidadesadd'
import CidadesEdit from './components/lista-cidadesedit'


const routes = [
	{path: '/', component: Principal},
	{path: '/cidades', component: Cidades},
	{path: '/cidades-add', component: CidadesAdd},
	{path: '/cidades-edit', component: CidadesEdit},
]

const router = new VueRouter({
	routes,
	mode: 'history'
})

const app = new Vue({ 
	    el: '#app',
	    router:router,
	    data: function () {
	          return {
		            version: Quasar.version,
		            drawerState: true,
		            cidades:[]
	          }
	    },
	    methods: {
    		launch: function (url) {
                //Quasar.utils.openURL(url)
                window.location.href = url;
    		},
    		launchurl: function (url) {
                Quasar.utils.openURL(url)
    		}
        },
	    components: {
	    	Principal,
	    	Cidades
	    }
	});