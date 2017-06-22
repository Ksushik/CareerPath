var path = require("path");
var webpack = require("webpack");
var StyleLintPlugin = require("stylelint-webpack-plugin");


var output = {
  path: path.join(__dirname, "/resources/"),
  filename: "js/output.js",
  publicPath: "resources/"
};

module.exports = {
  devtool: "cheap-inline-module-source-map",
  entry: [
    "babel-polyfill",
    "./src/index.js"
  ],
  output: output,
  module: {
    preLoaders: [
      { test: /\.json$/, loader: "json"},
      {
        test: /\.js$/,
        loader: "eslint",
        exclude: /node_modules/
      }
    ],
    loaders: [
      {
        loader: "babel-loader",
        exclude: /node_modules/,

        // Skip any files outside of your project's `src` directory
        include: [
          path.resolve(__dirname, "src")
        ],

        // Only run `.js` and `.jsx` files through Babel
        test: /\.jsx?$/,

        // Options to configure babel with
        query: {
          // plugins: ["transform-runtime", "lodash"],
          presets: ["es2015", "stage-0", "react"]
        }
      },
      {
        test: /\.s?css$/,
        loaders: [
          "style-loader",
          "css-loader",
          "postcss-loader?sourceMap=inline"
        ]
      },
      // {
      //   test: /\.(jpe?g|png|gif|svg|eot|woff|woff2|ttf)$/i,
      //   loaders: [
      //     //loads files and emits them in the output directory using hash for cache management
      //     "file?name=[path][name]-[sha512:hash:base64:7].[ext]"
      //     /**
      //      * bypassOnDebug - no processing is done when webpack 'debug' mode is used and the loader acts as a regular file-loader
      //      * optimizationLevel - optimization level between 0 and 7
      //      * interlaced - Interlace gif for progressive rendering
      //      * (!) image-webpack is disabled because it requires internet access at build time
      //      */
      //     // 'image-webpack?bypassOnDebug&optimizationLevel=7&interlaced=false'
      //   ]
      // }
    ]
  },
  // eslint: {
  //   configFile: ".eslintrc",
  //   failOnError: true
  // },
  postcss: function () {
    return [
      require("postcss-import"),
      require("precss"),
      require("postcss-assets")({
        relative: path.resolve(__dirname, "css"),
        loadPaths: ["images/"]
      }),
      require("autoprefixer")
    ];
  },
  plugins: [
    new webpack.optimize.OccurrenceOrderPlugin(),
    new webpack.ContextReplacementPlugin(/moment[\/\\]locale$/, /en-gb/),
    new StyleLintPlugin({
      configFile: ".stylelintrc",
      files: "css/**/*.css",
      failOnError: true
    })
  ],
  // watchOptions: {
  //   aggregateTimeout: 100
  // }
};