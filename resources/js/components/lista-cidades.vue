<template>
	<q-page padding>
		<table>
			<tr v-for="item in cidades">
				<td>{{item.id}}</td>
				<td>{{item.name}}</td>
				<td>{{item.estado}}</td>
				<td>{{item.localConcentracao}}</td>
				<td>{{item.hora}}</td>
			</tr>
		</table>
	</q-page>
</template>
<script>
	import axios from 'axios'
	export default {
    	data: function () {
	          return {
		            cidades:[]
	          }
        },
        mounted(){
        	axios.get("/api/cidades").then(
        		response => {
        			this.cidades = response.data
        			console.log(this.cidades)
        		}		
        	)
        },
    	methods: {
        },
        components: {
        }
    }
</script>