var JpegExifReader = function () {};

JpegExifReader.prototype.getWidth = function (params, onSuccess, onFail) {
    return cordova.exec(onSuccess, onFail, 'JpegExifReader', 'getWidth', [params]);
};

JpegExifReader.prototype.getLength = function (params, onSuccess, onFail) {
    return cordova.exec(onSuccess, onFail, 'JpegExifReader', 'getLength', [params]);
};

if (!window.plugins) {
    window.plugins = {};
}

if (!window.plugins.jpegExifReader) {
    window.plugins.jpegExifReader = new JpegExifReader();
}