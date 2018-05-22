//package com.qlool.java.base.thread.ThreadPool;
//
//public class ThreadPool{
//
//    private ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
//    public void todo(final String param, final CountDownLatch countDownLatch, final List<String> result) throws InterruptedException {
//        ListenableFuture listenableFuture = listeningExecutorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(100);
//                System.out.println("exec " + param);
//                result.add(String.valueOf(param));
//                System.out.println("exec "+param+" finished");
//                return String.valueOf(param);
//            }
//        });
//        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
//            @Override
//            public void onSuccess(String s) {
//                System.out.println("success "+s);
//                countDownLatch.countDown();
//            }
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                System.out.println("failed");
//                countDownLatch.countDown();
//            }
//        });
//    }
//    public static void main(String[] args) throws InterruptedException {
//        int taskSize = 4;
//        TestClass testClass = new TestClass();
//        final List<String> result = Lists.newArrayList();
//        final CountDownLatch countDownLatch = new CountDownLatch(taskSize);
//
//        for (int i = 0; i < taskSize; i++) {
//            testClass.todo("test" + i, countDownLatch, result);
//        }
//
//        System.out.println("add task finished");
//        countDownLatch.await(10, TimeUnit.SECONDS);
//        System.out.println(result);
//        testClass.listeningExecutorService.shutdown();
//    }
//    //*/
//}