module.exports = {
  env: {
    browser: true,
    es6: true,
  },
  extends: [
    'plugin:react/recommended',
    'airbnb',
    'plugin:jest/recommended',
  ],
  globals: {
    Atomics: 'readonly',
    SharedArrayBuffer: 'readonly',
  },
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 2018,
    sourceType: 'module',
  },
  plugins: [
    'react',
    'jest',
  ],
  rules: {
    'react/prop-types': 'off',
    'import/prefer-default-export': 1,
    'no-return-await': 1,
    'react/no-array-index-key': 1,
  },
  ignorePatterns: ['assets'],
  settings: {
    'import/resolver': {
      node: {
        paths: [__dirname],
      },
    },
  },
};
