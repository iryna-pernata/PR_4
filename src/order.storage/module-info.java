module order.storage {
    requires order.processing;  // Для взаємодії з модулем обробки замовлень
    requires thread.management;  // Для взаємодії з модулем управління потоками

    opens org.example.storage to order.processing;  // Дозволяємо доступ до цього пакета з модуля order.processing
}
