if (window.location.search.indexOf("?tests") !== -1) {
  document.write(
    '<div id="qunit"></div>' +
    '<div id="qunit-fixture"></div>' +
    '<div id="ember-testing-container">' +
    '  <div id="ember-testing"></div>' +
    '</div>' +
    '<link rel="stylesheet" href="runner.css">' +
    '<link rel="stylesheet" href="vendor/qunit-1.12.0.css">' +
    '<script src="vendor/qunit-1.12.0.js"></script>' +
    '<script src="tests.js"></script>'
  )
}
