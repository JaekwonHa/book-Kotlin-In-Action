open class View {
    constructor(ctx: String) {

    }

    constructor(ctx: String, attr: String) {

    }
}

class MyButton1 : View {
    constructor(ctx: String) : super(ctx) {

    }

    constructor(ctx: String, attr: String) : super(ctx, attr) {

    }
}

class MyButton2 : View {
    constructor(ctx: String) : this(ctx, "MY_STYLE") {

    }

    constructor(ctx: String, attr: String) : super(ctx, attr) {

    }
}
