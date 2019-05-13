package pl.dominisz.refactoringorderswriter;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");
        sb.append(getContentForOrders());
        return sb.append("]}").toString();
    }

    private String getContentForOrders() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append(getContentForOrder(order));

            if (i < orders.getOrdersCount() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private String getContentForOrder(Order order) {
        StringBuffer sb = new StringBuffer("{");
        sb.append("\"id\": ");
        sb.append(order.getId());
        sb.append(", ");
        sb.append("\"products\": [");
        sb.append(getContentForProducts(order));
        sb.append("]}");
        return sb.toString();
    }

    private String getContentForProducts(Order order) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < order.getProductsCount(); j++) {
            Product product = order.getProduct(j);

            sb.append(getContentForProduct(product));

            if (j < order.getProductsCount() -1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private String getContentForProduct(Product product) {
        StringBuffer sb = new StringBuffer("{");
        sb.append("\"code\": \"");
        sb.append(product.getCode());
        sb.append("\", ");
        sb.append("\"color\": \"");
        sb.append(getColorFor(product));
        sb.append("\", ");

        if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
            sb.append("\"size\": \"");
            sb.append(getSizeFor(product));
            sb.append("\", ");
        }

        sb.append("\"price\": ");
        sb.append(product.getPrice());
        sb.append(", ");
        sb.append("\"currency\": \"");
        sb.append(product.getCurrency());
        sb.append("\"}");

        return sb.toString();
    }

    private String getSizeFor(Product product) {
        switch (product.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor(Product product) {
        switch (product.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }
}