package de.tum.in.ase.eist.ecommerce;

public class ECommerceFacade {
    private final AdvertisementController advertisementController;
    private final OrderController orderController;
    private final ShippingController shippingController;

    public ECommerceFacade() {
        this.advertisementController = new AdvertisementController();
        this.orderController = new OrderController();
        this.shippingController = new ShippingController();
    }

    public void processOrder(Order order) {
        orderController.processOrder(order);
    }

    public void processOrder(Order order, String s) {
        orderController.processOrder(order, s);
    }

    public Order retrieveLatestOrder(int i) {
        return orderController.retrieveLatestOrder(i);
    }

    public void playAdvertisement(int i) {
        advertisementController.playAdvertisement(i);
    }

    public void shipOrder(Order order, String s) {
        Shipping shipping = shippingController.createShipping(s);
        order.setShipping(shipping);
        shippingController.shipOrder(order);
    }
}
