<template>
	<q-page>
		<h1>Página Inicial</h1>
	</q-page>
</template>
<script>
	
    export default {
    	
//     	meta: {
//     	    // sets document title
//     	    title: 'Index Page',

//     	    // meta tags
//     	    meta: {
//     	      description: { name: 'description', content: 'Page 1' },
//     	      keywords: { name: 'keywords', content: 'Quasar website' },
//     	      equiv: { 'http-equiv': 'Content-Type', content: 'text/html; charset=UTF-8' }
//     	    },
//     	},
    	
//     	data: function () {
// 	          return {
// 	          }
//         },
        mounted(){
//         	axios.get("/api/cidades").then(
//         		response => {
//         			this.cidades = response.data
//         			console.log(this.cidades)
//         		}		
//         	)
        },
    	methods: {
    		launch: function (url) {
                //Quasar.utils.openURL(url)
                window.location.href = url;
              }
        },
        components: {
        	
        }
    }
</script>