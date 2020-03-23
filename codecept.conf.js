const { setHeadlessWhen } = require('@codeceptjs/configure');

setHeadlessWhen(process.env.HEADLESS);

exports.config = {
  tests: './e2e/*.test.js',
  output: './output',
  helpers: {
    Puppeteer: {
      url: 'http://localhost:8080',
      show: false
    }
  },
  include: {
    I: './steps_file.js'
  },
  bootstrap: null,
  mocha: {},
  name: 'react-start-small',
  plugins: {
    retryFailedStep: {
      enabled: true
    },
    screenshotOnFail: {
      enabled: true
    }
  }
}