package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalsCage {

    @Autowired
    @Qualifier("dog")
    private Animal animal;
    @Autowired
    private Timer timer = new Timer();

    public Timer getTimer() {
        return timer;
    }

    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(animal.toString());
        System.out.println("At:");

        /*fixme 2024.03.18 12:03
        * Невозможно выполнение п.4 задания, т. к. происходит обращение к классу Timer(),
        * напрямую, минуя механизм Spring Context. По этой причине время всегда будет разным.
        * Чтобы время было одинаковым по условию задачи, необходимо обращаться к полю timer:
        *
        *   System.out.println(timer.getTime());
        *
        * При обращении к полю timer, будет происходить поиск бина в контейнере Spring,
        * и возврат одной и той же ссылки на объект (экземпляр) класса Timer,
        * не смотря даже на то, что полю присвоен вызов конструктора класса Timer.
        * Причиной такого поведения Spring является тип бина по умолчанию 'singleton'.*/
        System.out.println(new Timer().getTime());
        System.out.println("________________________");
    }
}
