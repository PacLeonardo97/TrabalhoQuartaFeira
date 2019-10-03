import javax.swing.JOptionPane;

public class Testando{
    
    public static void main(String[] args){
        //fornecedor
        Fornecedor fornecedor = new Fornecedor(1, "nome", "telefone", "endereco", "cnpj");
        String a  = fornecedor.toString();
        // System.out.println(a);
        JOptionPane.showMessageDialog(null, a);
        
        //produto
        Produto produto = new Produto(12, "nome", "telefone", "endereco", "cnpj", 2, "nomeProduto", "descricaoProduto", "setorProduto", "pesoProduto");
        String p  = produto.toString();
        // System.out.println(p);
        JOptionPane.showMessageDialog(null, p);
        
        //entrada produto
        EntradaProduto entradaProduto = new EntradaProduto(1, "caneta", "essa caneta é bonita", "setor de vendas", "5kg", 1, "18/04/1997", "15");
        String ep = entradaProduto.toString();
        System.out.println(ep);
    }
}