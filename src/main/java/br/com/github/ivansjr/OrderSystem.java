package br.com.github.ivansjr;
import java.util.*;

public class OrderSystem {

    private static final int CREATE_ORDER_OPTION = 1;
    private static final int ADD_ITEM_TO_ORDER_OPTION = 2;
    private static final int CALCULATE_TOTAL_ORDER_OPTION = 3;
    private static final int LIST_ITEMS_OF_ORDER_OPTION = 4;
    private static final int CLOSE_OPTION = 5;

    private final Scanner scanner;
    private final List<Order> orderList;

    public OrderSystem() {
        scanner = new Scanner(System.in);
        orderList = new ArrayList<>();
    }

    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();
        orderSystem.startMenu();
    }

    private void startMenu() {
        while (true) {
            showMenuOptions();
            int option = scanner.nextInt();
            switch (option) {
                case CREATE_ORDER_OPTION:
                    createOrder();
                    break;
                case ADD_ITEM_TO_ORDER_OPTION:
                    addItemToOrder();
                    break;
                case CALCULATE_TOTAL_ORDER_OPTION:
                    calculateTotalOrder();
                    break;
                case LIST_ITEMS_OF_ORDER_OPTION:
                    listOrderItems();
                    break;
                case CLOSE_OPTION:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void showMenuOptions() {
        System.out.println("1. Criar pedido");
        System.out.println("2. Adicionar Item ao pedido");
        System.out.println("3. Calcular Total do pedido");
        System.out.println("4. Listar Itens do pedido");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void createOrder() {
        Order order = new Order();
        orderList.add(order);
        System.out.println("Pedido criado.");
    }

    private void addItemToOrder() {
        if (checkIfThereAreOrders()) {
            System.out.print("Digite o nome do item: ");
            String itemName = scanner.next();
            System.out.print("Digite o preço do item: ");
            double itemPrice = scanner.nextDouble();
            Item item = new Item(itemName, itemPrice);
            Order lastOrder = getLastOrder();
            lastOrder.addItem(item);
            System.out.println("Item adicionado ao pedido.");
        }
    }

    private void calculateTotalOrder() {
        if (checkIfThereAreOrders()) {
            Order lastOrder = getLastOrder();
            double total = lastOrder.calculateTotal();
            System.out.println("Total do pedido: " + total);
        }
    }

    private void listOrderItems() {
        if (checkIfThereAreOrders()) {
            Order lastOrder = getLastOrder();
            List<Item> lastOrderItens = lastOrder.getItems();
            System.out.println("Itens do pedido:");
            for (Item i : lastOrderItens) {
                System.out.println(i.getName() + ": " + i.getPrice());
            }
        }
    }

    private boolean checkIfThereAreOrders() {
        if (orderList.isEmpty()) {
            System.out.println("Crie um pedido primeiro.");
            return false;
        }
        return true;
    }

    private Order getLastOrder() {
        return orderList.get(orderList.size() - 1);
    }
}


