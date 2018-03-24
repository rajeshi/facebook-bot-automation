package com.gilly.automation_framework.jmx.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class JThreadGroup extends BaseInfo implements Serializable {

    @XmlElement(name="stringProp")
    private StringProp on_sample_error;
    @XmlElement(name="elementProp")
    private ElementProperty main_controller;
    @XmlElement(name="stringProp")
    private StringProp num_threads;
    @XmlElement(name="stringProp")
    private StringProp ramp_time;
    @XmlElement(name="longProp")
    private LongProp start_time;
    @XmlElement(name="longProp")
    private LongProp end_time;
    @XmlElement(name="boolProp")
    private BoolProp scheduler;
    @XmlElement(name="stringProp")
    private StringProp duration;
    @XmlElement(name="stringProp")
    private StringProp delay;
    @XmlElement(name="boolProp")
    private BoolProp delayedStart;

    public JThreadGroup() {
        super("ThreadGroupGui", "ThreadGroup", "ThreadGroup", true);
    }

    public StringProp getOn_sample_error() {
        return on_sample_error;
    }

    public void setOn_sample_error(String on_sample_error) {
        this.on_sample_error = new StringProp();
        this.on_sample_error.setName("ThreadGroup.on_sample_error");
        this.on_sample_error.setValue(on_sample_error);
    }

    public ElementProperty getMain_controller() {
        return main_controller;
    }

    public void setMain_controller(String main_controller) {
        this.main_controller = new ElementProperty("ThreadGroup.main_controller", "LoopController", "LoopControlPanel", "LoopController", "ThreadGroup", true);
        BoolProp continueForever = new BoolProp();
        continueForever.setName("LoopController.continue_forever");
        continueForever.setValue(false);
        this.main_controller.getProperties().add(continueForever);
        IntProp loops = new IntProp();
        loops.setName("LoopController.loops");
        loops.setValue(-1);
        this.main_controller.getProperties().add(loops);
    }

    public StringProp getNum_threads() {
        return num_threads;
    }

    public void setNum_threads(String num_threads) {
        this.num_threads = new StringProp();
        this.num_threads.setName("ThreadGroup.num_threads");
        this.num_threads.setValue(num_threads);
    }

    public StringProp getRamp_time() {
        return ramp_time;
    }

    public void setRamp_time(String ramp_time) {
        this.ramp_time = new StringProp();
        this.ramp_time.setName("ThreadGroup.ramp_time");
        this.ramp_time.setValue(ramp_time);
    }

    public LongProp getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = new LongProp();
        this.start_time.setName("ThreadGroup.start_time");
        this.start_time.setValue(start_time);
    }

    public LongProp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = new LongProp();
        this.end_time.setName("ThreadGroup.end_time");
        this.end_time.setValue(end_time);
    }

    public BoolProp getScheduler() {
        return scheduler;
    }

    public void setScheduler(boolean scheduler) {
        this.scheduler = new BoolProp();
        this.scheduler.setName("ThreadGroup.scheduler");
        this.scheduler.setValue(scheduler);
    }

    public StringProp getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = new StringProp();
        this.duration.setName("ThreadGroup.duration");
        this.duration.setValue(duration);
    }

    public StringProp getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = new StringProp();
        this.delay.setName("ThreadGroup.delay");
        this.delay.setValue(delay);
    }

    public BoolProp getDelayedStart() {
        return delayedStart;
    }

    public void setDelayedStart(boolean delayedStart) {
        this.delayedStart = new BoolProp();
        this.delayedStart.setName("ThreadGroup.delayedStart");
        this.delayedStart.setValue(delayedStart);
    }
    
    
}
