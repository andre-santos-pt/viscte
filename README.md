# VISCTE
This is a tool for runtime exploration of OSGi systems, integrated with Eclipse. It has a view to display component bindings recorded by a user-controlled process.

# Installation

In order to install VISCTE on your Eclipse, download **viscte_plugins.zip** from the Releases section and unzip the contained jar files into Eclipse *dropins* folder. This Eclipse plugin will add a new view named *Components* (category: Other). The plugin was tested on Eclipse Mars release. Uninstall simply by deleting the jars from the *dropins* folder.

# Project setup
In order to use VISCTE, you must configure the projects and launch configuration of the system that you want to explore.

* add the bundle `pt.iscte.osgi.viscte.bundlemonitor` to the run configuration (setting `Auto-Start` to `true`)
* additionally, add the following bundles to the run configuration (which are necessary for AspectJ instrumentation)
    * `org.aspectj.runtime`
    * `org.aspectj.weaver`
    * `org.eclipse.equinox.weaving.aspectj`  (setting `Auto-Start` to `true`)
* add the following VM argument to the launch configuration: `-Dosgi.framework.extensions=org.eclipse.equinox.weaving.hook`

Add the dependency `pt.iscte.osgi.viscte.bundlemonitor` to each component that you wish to monitor. Only those with this dependency will be instrumented. 

Hit the Capture button to start/stop recording. By clicking on the components in the diagram you navigate to the corresponding `MANIFEST-MF`descriptor editor (if available in the workspace), whereas by clicking on the bindings you navigate to the service implementation that is being used.



