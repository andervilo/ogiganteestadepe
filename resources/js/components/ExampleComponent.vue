<template>
	<q-layout view="lHh Lpr fff">
        <q-layout-header>
          <q-toolbar color="secondary" inverted
          >
            <q-btn flat round dense @click="drawerState = !drawerState" icon="fas fa-bars"></q-btn>

            <q-toolbar-title>
              Quasar App {{version}}
              <div slot="subtitle">Running on Quasar </div>
            </q-toolbar-title>
          </q-toolbar>
        </q-layout-header>

        <q-layout-drawer
          v-model="drawerState"
          :content-class="$q.theme === 'mat' ? 'bg-teal' : null"
        >
          <q-list no-border link inset-delimiter>
            <q-list-header class="text-white">Essential Links</q-list-header>
            <q-item @click.native="launch('http://quasar-framework.org')">              
              <q-item-main class="text-white" label="Docs" ></q-item-main>
            </q-item>
            <q-item @click.native="launch('https://discord.gg/5TDhbDg')">
              <q-item-main class="text-white" label="Discord Chat Channel" ></q-item-main>
            </q-item>
            <q-item @click.native="launch('http://forum.quasar-framework.org')">
              <q-item-main class="text-white" label="Forum" ></q-item-main>
            </q-item>
            <q-item @click.native="launch('https://twitter.com/quasarframework')">
              <q-item-main class="text-white" label="Twitter" ></q-item-main>
            </q-item>
          </q-list>
        </q-layout-drawer>

        <q-page-container>
          <Teste></Teste>
          <q-btn color="primary" icon="warning" label="Notify" @click="notify" class="q-ma-md"></q-btn>
        </q-page-container>
      </q-layout>
</template>

<script>
	import Teste from './TesteComponent'
    export default {
    	data: function () {
	          return {
		            version: Quasar.version,
		            drawerState: true
	          }
        },
    	methods: {
	          launch: function (url) {
	            	Quasar.utils.openURL(url)
	          },
	          notify: function () {
	              this.$q.notify('Running on Quasar v' + this.$q.version)
	          }
        
        },
        components: {
        	Teste
        }
    }
</script>