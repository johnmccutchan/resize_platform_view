import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo #126201',
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final ValueNotifier<double> currentSize = ValueNotifier(50);

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ValueListenableBuilder<double>(
                valueListenable: currentSize,
                builder: (context, double size, child) {
                  return AnimatedContainer(
                      height: size,
                      width: size,
                      duration: const Duration(milliseconds: 500),
                      child: AndroidView(viewType: 'static-text-view'));
                },
              ),
              changeSizeWidget(),
            ],
          ),
        ),
      ),
    );
  }

  Widget changeSizeWidget() {
    return ElevatedButton(
        onPressed: () {
          currentSize.value =
              currentSize.value == 50 ? MediaQuery.of(context).size.width : 50;
        },
        child: Text('Change size'));
  }
}
