dependencies {
    implementation(project(":common"))
    implementation("com.playtika.reactivefeign:feign-reactor-spring-configuration:4.0.0")
    implementation("com.playtika.reactivefeign:feign-reactor-webclient:4.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}