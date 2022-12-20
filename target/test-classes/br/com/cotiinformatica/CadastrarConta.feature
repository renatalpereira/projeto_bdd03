#language: pt

Funcionalidade: Cadastrar Conta
como um usuário do sistema
eu quero cadastrar minhas contas a pagar ou a receber
para que eu possa gerenciar minhas finanças


Cenário: Cadastro de conta a pagar com sucesso

	Dado Acessar a página de cadastro de contas
	E Informar o nome do cliente
	E Informar a data da conta
	E Informar o valor da conta
	E Informar as observações
	E Informar o tipo de conta a pagar
	Quando Solicitar o cadastro da conta
	Então Sistema cadastra a conta com sucesso
	

Cenário: Cadastro de conta a receber com sucesso

	Dado Acessar a página de cadastro de contas
	E Informar o nome do cliente
	E Informar a data da conta
	E Informar o valor da conta
	E Informar as observações
	E Informar o tipo de conta a receber
	Quando Solicitar o cadastro da conta
	Então Sistema cadastra a conta com sucesso
