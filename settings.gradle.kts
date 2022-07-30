rootProject.name = "empty-plugins"

//include("empty-EvilDragons")
//include("empty-Motherlode")
//include("empty-NightmareZone")
//include("empty-CooksAssistant")
//include("empty-MooBank")
//include("empty-ScriptTemplate")
//include("empty-LavaDragons")
//include("empty-Absorption")
//include("empty-RockCake")
include("empty-PrayerFlicker")
include("empty-Overload")




for (project in rootProject.children) {
    project.apply {
        projectDir = file(name)
        buildFileName = "$name.gradle.kts"

        require(projectDir.isDirectory) { "Project '${project.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${project.path} must have a $buildFile build script" }
    }
}
