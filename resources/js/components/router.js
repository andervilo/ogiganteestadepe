
import Cidades from './lista-cidades'
import Principal from './principal'

export default [
  {	
    path: '/',
    component: Principal,
    children: [
      {
        path: 'cidades',
        component: Cidades
      }
    ]
  }
]
