package br.com.extra.api.resources.v1;

import java.util.List;

import br.com.extra.api.core.exception.ServiceException;
import br.com.extra.api.pojo.v1.sellerItems.SellerItem;

/**
 * ExtraAPI-SDK - SellerItemsResource.java
 * 
 * Interface do Serviço Restful /sellerItems.
 * 
 * Serviço que possibilita ao lojista gerenciar os produtos que ele vende.
 * 
 * @author Gibson Pasquini Nascimento
 * @author Fillipe Massuda
 * 
 *         21/06/2013
 */
public interface SellerItemsResource {

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * recupera itens do lojista que já estão disponíveis para venda
	 * relacionados com o token do lojista informado.
	 * <p/>
	 * 
	 * GET /sellerItems/status/selling
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de pedidos disponíveis para venda.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<SellerItem> getAvailableSellerItems(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * responsável por recuperar detalhes do item do Lojista por SKU.
	 * <p/>
	 * GET /sellerItems/{skuId}
	 * 
	 * @param skuID
	 *            SKU ID do produto no Marketplace.
	 * @return Detalhes do item.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public SellerItem getSellerItemBySkuID(String skuID)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful
	 * responsável por recuperar detalhes do item do Lojista por SKU do Lojista.
	 * <p/>
	 * GET /sellerItems/skuOrigin/{skuOrigin}
	 * 
	 * @param skuOrigin
	 *            SKU ID do produto do Lojista.
	 * @return Detalhes do item.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public SellerItem getSellerItemBySkuOrigin(String skuOrigin)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que é
	 * responsável por recuperar lista de produtos que são vendidos pelo
	 * Lojista.
	 * <p/>
	 * GET /sellerItems
	 * 
	 * @param offset
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos por página.
	 * @param limit
	 *            Parâmetro utilizado para limitar a quantidade de registros
	 *            trazidos pela operação.
	 * @return Lista de produtos vendidos pelo lojista.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public List<SellerItem> getSellerItems(String offset, String limit)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que faz a
	 * associação do produto ao lojista.
	 * <p/>
	 * POST /sellerItems
	 * 
	 * @param sellerItem
	 *            Objeto contendo os parâmetros que precisam ser passados no
	 *            body da requisição. Exemplo de conteúdo que pode ser
	 *            preenchido:
	 *            <p/>
	 *            {<br/>
	 *            "skuOrigin": "string",<br/>
	 *            "skuId": "string",<br/>
	 *            "defaultPrice": "500.00",<br/>
	 *            "salePrice": "460.00",<br/>
	 *            "availableQuantity": "100",<br/>
	 *            "installmentId": "20p3x",<br/>
	 *            "totalQuantity": "250",<br/>
	 *            "crossDockingTime": 1<br/>
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean postSellerItem(SellerItem sellerItem)
			throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * atualiza o preço dos items do Lojista.
	 * <p/>
	 * 
	 * PUT /sellerItems/{skuId}/prices
	 * 
	 * @param skuId
	 *            SKU ID do produto a venda.
	 * @param defaultPrice
	 *            Preço 'de'.
	 * @param salePrice
	 *            Preço 'por'.
	 * @param installmentId
	 *            Parcelamento do produto.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean uptadePrice(String skuId, Double defaultPrice,
			Double salePrice, String installmentId) throws ServiceException;

	/**
	 * Método utilizado para realizar a chamada ao WebService Restful que
	 * atualiza a quantidade disponível para venda de um item do Lojista.
	 * <p/>
	 * PUT /sellerItems/{skuId}/stock
	 * 
	 * @param skuId
	 *            SKU ID do produto a venda.
	 * @param availableQuantity
	 *            Quantidade disponível.
	 * @param totalQuantity
	 *            Quantidade total de produtos.
	 * @return Confirmação da execução da operação.
	 * @throws ServiceException
	 *             Exceção lançada caso ocorra algum erro na execução do
	 *             serviço.
	 */
	public Boolean uptadeStock(String skuId, Integer availableQuantity,
			Integer totalQuantity, Integer crossDockingTime) throws ServiceException;
}
