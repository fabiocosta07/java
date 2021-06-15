import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestFlux {
    private static final Logger logger
            = LoggerFactory.getLogger(TestFlux.class);

    public static void main(String[] args) {

        List<Integer> sl = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(sl::add);
        logger.info("simple list - list result l {}",sl);

        List<Integer> l = new ArrayList<Integer>();
        Flux<Integer> just = Flux.just(1, 2, 3, 4);
        just.log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int onNextAmount;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.s = subscription;
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        l.add(integer);
                        onNextAmount++;
                        if (onNextAmount % 2 ==0){
                            s.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        logger.info("backPressure example - list result l {}",l);

        List<String> l2 = new ArrayList<String>();
        Flux.just(1,2,3,4)
                .log()
                .map(i->i*2)
                .zipWith(Flux.range(0, Integer.MAX_VALUE),(one, two) -> String.format("First %d, second %d", one, two))
                .subscribe(l2::add);
        logger.info("zipWith example - list result l2 {}",l2);

        ConnectableFlux<Object> publish = Flux.create(
                objectFluxSink -> {
                    while(true){
                        objectFluxSink.next(System.currentTimeMillis());
                    }
                }
        ).sample(Duration.ofSeconds(2)).publish();

        publish.subscribe(System.out::println);
        publish.connect();

        List<Integer> l3 = new ArrayList<Integer>();

        Flux.just(1,2,3,4)
                .log()
                .map(i -> i*2)
                .subscribeOn(Schedulers.parallel())
                .subscribe(l3::add);
        System.out.println(l3);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Parallel schedule example - list result l3 {}",l3);
    }

}
