1、MutableLiveData 和 LiveData区别
2、@SuppressLint("CheckResult") 不用这个有什么结果
3、!::mealsMutableLiveData.isInitialized 含义，没什么要输入!:: 才能调用isInitialized
4、.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
.subscribe

public final Disposable subscribe(Consumer<? super T> onNext, Consumer<? super Throwable> onError,
Action onComplete, Consumer<? super Disposable> onSubscribe)
理解

5、io.reactivex.Completable 作用

   ···
   Single, Maybe, Completable 都是可观察的数据流 Observable 的变体。

Observable
发送0个，1个或多个数据（Next），最后以出错（Error）或完成（Complete）事件收尾。
出错或完成事件可以不出现，但是出错或完成事件之后不可再发送数据。
Single
成功发送1个数据（Success），或者出错（Error）。
Maybe
成功发送1个数据（Success），或者出错（Error）或完成（Complete）。
Completable
出错（Error）或完成（Complete）。
与Observable 有所不同，这些变体最多只发送一个数据。
···

6、ViewModelProvider.Factory 作用
  参考网站：https://blog.csdn.net/qq_43377749/article/details/100856599
为什么我们需要 ViewModelProvider.Factory ?
我们心中有这样一些疑问，我们不能直接在活动或碎片中将值传入 ViewModel 构造方法中去，我需要写法来设置我们的参数值使其正常工作，
这就是为什么我们需要 ViewModelProver.Factory，在一些情况下你可以不使用，但在某些特定情形下，你需要使用 ViewModelProver.Factory。

什么时候使用 ViewModelProvider.Factory
当你的 ViewModel 有依赖项，并且你需要将这些依赖项通过构造方法传入，因此，您可以模拟该依赖项并测试 ViewModel。

什么时候不应该使用 ViewModelProvider.Factory
如果你的 ViewModel 没有依赖项，这时你就不需要去自己创建 ViewModelProvider.Factory。系统自带的方法，注意帮助你创建 ViewModel。

总结
ViewModelProvider.Factory 负责帮你创建 ViewModel 实例。当你的 ViewModel 存在依赖项，且你希望测试你的 ViewModel 时，
你需要创建自己的 ViewModelProvider.Factory 来通过 ViewModel 的构造方法传递依赖项，将你的数值传入 ViewModelProvider.Factory 实例中去

7、::class.java 


8、com.hw.game.module_sdk.data.db  RoomDB 不添加这个 exportSchema=false
   会报：
Schema export directory is not provided to the annotation processor so we cannot export the schema. You can either provide room.schemaLocation annotation processor argument OR set exportSchema to false.
Schema是数据库的组织和结构，exportSchema指暴露数据库的组织架构到一个文件夹，这个文件夹通过room.schemaLocation指定。Schema记录了数据库的组织和结构，并带有版本信息，所以不适合在发布的app中的文件夹中，而是最好指定到版本控制系统中，默认为true打开状态。所以系统编译是，提醒你。


  