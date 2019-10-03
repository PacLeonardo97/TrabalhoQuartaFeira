import javax.swing.JOptionPane;

public class Testando{
    
    public static void main(String[] args){
        
        Fornecedor fornecedor = new Fornecedor(1, "nome", "telefone", "endereco", "cnpj");
        String a  = fornecedor.toString();
        Produto = produto = new Produto(a, 1, "nomeProduto", "descricaoProduto", "setorProduto", "pesoProduto");
        
        System.out.println(a);
        JOptionPane.showMessageDialog(null, a);
        
    }
}