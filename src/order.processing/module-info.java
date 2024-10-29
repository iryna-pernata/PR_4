module order.processing {
    requires java.base;  // Базовий модуль Java
    requires thread.management;  // Для взаємодії з модулем управління потоками

    exports org.example.processing to order.storage;  // Експортуємо пакет для модуля order.storage
}
