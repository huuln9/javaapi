import 'package:flutter/material.dart';
import 'package:get/get.dart';

class Setting extends StatefulWidget {
  const Setting({Key? key}) : super(key: key);

  @override
  State<Setting> createState() => _SettingState();
}

class _SettingState extends State<Setting> {
  bool english = Get.locale == const Locale('en', 'US') ? true : false;

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(
          flexibleSpace: const Image(
            image: NetworkImage(
                'https://raw.githubusercontent.com/huuln9/images/main/banner_2.png'),
            fit: BoxFit.cover,
          ),
          leading: IconButton(
            icon: const Icon(
              Icons.arrow_back_ios,
              color: Colors.white,
            ),
            onPressed: () => {},
          ),
          title: Align(
            alignment: Alignment.centerLeft,
            child: Text(
              "Setting".tr,
              style: const TextStyle(fontSize: 20, color: Colors.white),
            ),
          ),
        ),
        body: ScrollConfiguration(
          behavior: ScrollConfiguration.of(context).copyWith(scrollbars: false),
          child: ListView(
            children: [
              const Padding(padding: EdgeInsets.only(top: 10)),
              ListTile(
                onTap: () {
                  setState(() {
                    english = !english;
                  });
                  if (english) {
                    Get.updateLocale(const Locale('en', 'US'));
                  } else {
                    Get.updateLocale(const Locale('vi', 'VN'));
                  }
                },
                leading: const Icon(Icons.language, color: Colors.black),
                title: Text(
                  "English".tr,
                  style: const TextStyle(fontSize: 18),
                ),
                trailing: Padding(
                  padding: const EdgeInsets.only(right: 8.0, bottom: 8.0),
                  child: english
                      ? const Icon(
                          Icons.toggle_on,
                          size: 50,
                          color: Colors.green,
                        )
                      : const Icon(
                          Icons.toggle_off,
                          size: 50,
                          color: Colors.black54,
                        ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.only(left: 10, right: 10, bottom: 10),
                child: Divider(thickness: 1.0),
              ),
              ListTile(
                leading: const Icon(Icons.notifications, color: Colors.black),
                title: Text(
                  "Enable notifications".tr,
                  style: const TextStyle(fontSize: 18),
                ),
                trailing: const Padding(
                  padding: EdgeInsets.only(right: 8.0, bottom: 8.0),
                  child:
                      Icon(Icons.toggle_off, size: 50, color: Colors.black54),
                ),
              ),
              const Padding(
                padding: EdgeInsets.only(left: 10, right: 10, bottom: 10),
                child: Divider(thickness: 1.0),
              ),
              ListTile(
                leading: const Icon(Icons.message, color: Colors.black),
                title: Text(
                  "Comment".tr,
                  style: const TextStyle(fontSize: 18),
                ),
              ),
              const Padding(
                padding: EdgeInsets.only(left: 10, right: 10, bottom: 10),
                child: Divider(thickness: 1.0),
              ),
              ListTile(
                leading: const Icon(Icons.phone_android, color: Colors.black),
                title: Text(
                  "Version".tr,
                  style: const TextStyle(fontSize: 18),
                ),
                trailing: const Text(
                  "1.0.0",
                  style: TextStyle(fontSize: 18, color: Colors.blue),
                ),
              ),
              const Padding(
                padding: EdgeInsets.only(left: 10, right: 10, bottom: 10),
                child: Divider(thickness: 1.0),
              ),
              ListTile(
                leading: const Icon(
                  Icons.ondemand_video,
                  color: Colors.black,
                ),
                title: Text(
                  "Instructional clips".tr,
                  style: const TextStyle(fontSize: 18),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
