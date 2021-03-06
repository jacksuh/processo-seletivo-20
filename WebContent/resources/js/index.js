var inicio = new Vue({
	el:"#inicio",
    data: {
        listaProdutos: [],
        listaProdutosHeader: [
			{sortable: false, key: "funcionario.nome", label:"Nome"},
			{sortable: false, key: "fabricante.nome", label:"Setor"},
			{sortable: false, key: "volume", label:"Volume"},
			{sortable: false, key: "unidade", label:"Unidade"},
			{sortable: false, key: "estoque", label:"Estoque"}
		]
    },
    created: function(){
        let vm =  this;
        vm.buscaProdutos();
    },
    methods:{
        buscaProdutos: function(){
			const vm = this;
			axios.get("/funcionarios/rs/funcionarios")
			.then(response => { vm.listaProdutos = response.data;
			}).catch(function (error) {
				vm.mostraAlertaErro("Erro interno", "Não foi listar os Funcionarios");
			}).finally(function() {
			});
		},
    }
});