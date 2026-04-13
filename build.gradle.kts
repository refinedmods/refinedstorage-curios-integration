plugins {
    id("com.refinedmods.refinedarchitect.root")
    id("com.refinedmods.refinedarchitect.neoforge")
}

repositories {
    maven {
        name = "Refined Storage"
        url = uri("https://maven.creeperhost.net")
        content {
            includeGroup("com.refinedmods.refinedstorage")
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
        curseForgeRequiredDependencies = listOf("refined-storage", "curios")
        modrinth = "s6zjL86N"
        modrinthRequiredDependencies = listOf("refined-storage", "curios")
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