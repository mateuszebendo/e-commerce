package org.br.serratec.ecommerce.enums;

public enum StatusPedidoEnum {
	ABERTO,  				// Todo pedido criado
    REALIZADO,				// Fechou o pedido
    EM_PROCESSAMENTO,		// Equipe separando produtos
    CANCELADO,				// Cliente cancelou
    ENVIADO,				// Pedido enviado
    FINALIZADO				// Pedido entregue
}
