var app = new Vue({
	el:"#app",
    data: {
       return {
            form: {
                nome: '',
                setor: '',
                salario: '',
                email: '',
                idade: ''
            }
        }
    },
    methods:{
        submit(){
            axios.post('/funcionarios/rs/novo', this.form)
                .then(function( response ){
                }.bind(this));
        	}
		}
    }
})