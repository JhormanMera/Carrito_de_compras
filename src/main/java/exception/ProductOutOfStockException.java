package exception;

public class ProductOutOfStockException extends Exception {

    public ProductOutOfStockException() {
        super("Actualmente no hay disponibilidad de este producto");
    }
}