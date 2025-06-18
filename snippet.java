private static URL[] getExtensionURLs() {
    List<URL> urls = new ArrayList<>();
    String home = SystemPropertyUtils.resolvePlaceholders("${spring.home:${SPRING_HOME:.}}");
    File extDirectory = new File(new File(home, "lib"), "ext");
    if (extDirectory.isDirectory()) {
        for (File file : extDirectory.listFiles()) {
            if (file.getName().endsWith(".jar")) {
                try {
                    urls.add(file.toURI().toURL());
                }
                catch (MalformedURLException ex) {
                    throw new IllegalStateException(ex);
                }
            }
        }
    }
    return urls.toArray(new URL[0]);
}
