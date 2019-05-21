<template>
	<q-page padding>
		<div>
			
		    <q-input
		      v-model="cidade.name"
		      float-label="Cidade" 
		      placeholder="Cidade"
		    />
		    <q-select
		      v-model="cidade.estado"
		      float-label="Estado"
		     :options="estados"
		    />
		    <q-input
		      v-model="cidade.localConcentracao"
		      float-label="Local de Concentração" 
		      placeholder="Local de Concentração"
		    />
		    <q-datetime v-model="cidade.hora" :format24h="format24h" type="time" float-label="Hora" placeholder="Hora"/>
			<br>
		    <q-btn color="secondary" @click="save">Salvar</q-btn>
	  	</div>
		
  	</q-page>

</template>
<script>
// let timeStamp = Date.now()
// let formattedString = date.formatDate(timeStamp, 'YYYY-MM-DDTHH:mm:ss.SSSZ')
	import axios from 'axios'
	const d = new Date()
	export default{
	
		data: function () {
	          return {
		            cidade:{
		            	id:"",
		            	name:"",
		            	estado:"",
		            	localConcentracao:"",
		            	hora:""
		            },
		            estados:[],
		            format24h:true,
		            hora:d.getHours()+":"+d.getMinutes()
	            
	          }
        },
        methods: {
          save: function () {
        	  this.cidade.hora = new Date(this.cidade.hora).getHours()+":"+new Date(this.cidade.hora).getMinutes()
        	  axios
        	  .post("/api/cidades",this.cidade)
        	  .then(response => {
              			this.cidades = response.data
              			console.log(this.cidades)
              			this.$router.push('/cidades')
              		}		
             	)
             	.catch(error => console.log(error))
          }
        },
        mounted() {
           axios
      	  .get("/api/estados")
      	  .then(response => {
            			this.estados = response.data
            			console.log(this.estados)
            		}		
           	)
           	.catch(error => console.log(error))
        }
	}
</script>