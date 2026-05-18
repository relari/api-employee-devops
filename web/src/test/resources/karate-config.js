function fn() {
    var Properties = Java.type('java.util.Properties');
    var FileInputStream = Java.type('java.io.FileInputStream');

    // load .properties
    var props = new Properties();
    var fis = new FileInputStream('src/test/resources/env-dev.properties');
    props.load(fis);
    fis.close();

    var baseUrl = props.getProperty('baseUrl');
    karate.log('Base URL is: ' + baseUrl);

    var applicationApiPath = props.getProperty('application.api.path');
    karate.log('Path is: ' + applicationApiPath);

    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.configure('ssl', true);

    karate.configure('logPrettyRequest', true);
    karate.configure('logPrettyResponse', true);
    karate.configure('report', { showLog: true, showAllSteps: true });

    return {
      baseUrl: baseUrl,
      applicationApiPath: applicationApiPath
    };
}