package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should send a synchronize campaign message for DSP1 processor"
    label "triggerDsp1Campaign"
    input {
        triggeredBy("triggerSynchronizeDsp1CampaignMessage()")
    }
    outputMessage {
        sentTo "ha.dsp1.out"
        body([
               'start.date': '2017-10-15T00:00:00Z',
               'entity.a': [
                       'field.int': 9999
               ],
               'entity.b': [
                       'field.string': 'Random String'
               ]
        ])
        headers {
            header('contentType', 'application/json;charset=UTF-8')
        }
    }
}
