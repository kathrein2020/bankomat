ПО (создано с помощью Springboot) состоит из главного меню  http://localhost:8080/index.

Где есть пункты:

Получить баланс клиента  
Положить деньги на баланс
Снять деньги из баланса
Список клиентов
Добавить нового клиента

Данные хранятся в Postgresql

    //вычитание заданного баланса amount у донора клиента по id
    @PutMapping("transferDel/{id}/{balance}/{amounts}")
    
    //добавление заданного баланса amount рецептиенту клиенту по id
    @PutMapping("transferAdd/{id}/{balance}/{amounts}")
