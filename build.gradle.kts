plugins {
    id("refinedarchitect.root")
    id("refinedarchitect.neoforge")
}

repositories {
    maven {
        url = uri("https://maven.pkg.github.com/refinedmods/refinedstorage2")
        credentials {
            username = "anything"
            password = "\u0067hp_oGjcDFCn8jeTzIj4Ke9pLoEVtpnZMP4VQgaX"
        }
    }
    maven {
        name = "Curios"
        url = uri("https://maven.theillusivec4.top/")
    }
}

refinedarchitect {
    modId = "refinedstorage_curios_integration"
    neoForge()
    sonarQube("refinedmods_refinedstorage-curios-integration", "refinedmods")
    publishing {
        maven = true
        curseForge = "1230729"
        modrinth = "s6zjL86N"
    }
}

group = "com.refinedmods.refinedstorage"

base {
    archivesName.set("refinedstorage-curios-integration")
}

val refinedstorageVersion: String by project
val curiosVersion: String by project

dependencies {
    api("com.refinedmods.refinedstorage:refinedstorage-neoforge:${refinedstorageVersion}")
    runtimeOnly("top.theillusivec4.curios:curios-neoforge:${curiosVersion}")
    compileOnlyApi("top.theillusivec4.curios:curios-neoforge:${curiosVersion}:api")
}