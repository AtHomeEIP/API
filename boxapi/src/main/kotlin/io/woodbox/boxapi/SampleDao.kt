package io.woodbox.boxapi

import org.springframework.stereotype.Component


@Component
class SampleDao{
    private val data = mutableListOf(
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 3}", "2017-19-01"),
            Sample("1", "{data: 6}", "2017-19-01"),
            Sample("1", "{data: 7}", "2017-19-01"),
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 3}", "2017-19-01"),
            Sample("1", "{data: 2}", "2017-19-01"),
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 4}", "2017-19-01"),
            Sample("1", "{data: 1}", "2017-19-01"),
            Sample("1", "{data: 3}", "2017-19-01"),
            Sample("2", "{data: 1}", "2017-19-01"),
            Sample("2", "{data: 2}", "2017-19-01"),
            Sample("2", "{data: 3}", "2017-19-01"),
            Sample("2", "{data: 4}", "2017-19-01"),
            Sample("2", "{data: 5}", "2017-19-01"),
            Sample("2", "{data: 6}", "2017-19-01"),
            Sample("2", "{data: 7}", "2017-19-01"),
            Sample("2", "{data: 8}", "2017-19-01"),
            Sample("2", "{data: 9}", "2017-19-01"),
            Sample("2", "{data: 3}", "2017-19-01"),
            Sample("2", "{data: 2}", "2017-19-01"),
            Sample("2", "{data: 1}", "2017-19-01"),
            Sample("3", "{data: 9}", "2017-19-01"),
            Sample("3", "{data: 8}", "2017-19-01"),
            Sample("3", "{data: 7}", "2017-19-01"),
            Sample("3", "{data: 6}", "2017-19-01"),
            Sample("3", "{data: 5}", "2017-19-01"),
            Sample("3", "{data: 4}", "2017-19-01"),
            Sample("3", "{data: 3}", "2017-19-01"),
            Sample("3", "{data: 3}", "2017-19-01"),
            Sample("3", "{data: 1}", "2017-19-01"),
            Sample("3", "{data: 9}", "2017-19-01"),
            Sample("4", "{data: 2}", "2017-19-01"),
            Sample("4", "{data: 5}", "2017-19-01"),
            Sample("4", "{data: 7}", "2017-19-01"),
            Sample("4", "{data: 9}", "2017-19-01"),
            Sample("4", "{data: 2}", "2017-19-01"),
            Sample("5", "{data: 1}", "2017-19-01"),
            Sample("5", "{data: 2}", "2017-19-01"),
            Sample("5", "{data: 4}", "2017-19-01"),
            Sample("5", "{data: 6}", "2017-19-01"),
            Sample("5", "{data: 8}", "2017-19-01"),
            Sample("5", "{data: 3}", "2017-19-01"),
            Sample("5", "{data: 5}", "2017-19-01"),
            Sample("5", "{data: 7}", "2017-19-01"),
            Sample("5", "{data: 9}", "2017-19-01"),
            Sample("5", "{data: 1}", "2017-19-01"),
            Sample("5", "{data: 3}", "2017-19-01")
    )
    fun getSamplesByModuleId(moduleId: String) = data.filter{sample -> sample.moduleId == moduleId }
}